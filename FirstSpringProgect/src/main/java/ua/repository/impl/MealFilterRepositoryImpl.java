package ua.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.entity.Cafe;
import ua.entity.Meal;
import ua.entity.Cuisine;
import ua.entity.Ingredient;
import ua.model.filter.MealFilter;
import ua.model.view.MealView;
import ua.repository.MealFilterRepository;

@Repository
public class MealFilterRepositoryImpl implements MealFilterRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<MealView> findAll(MealFilter filter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MealView> cq = cb.createQuery(MealView.class);
		Root<Meal> root = cq.from(Meal.class);
		//Integer id, String title, String description, BigDecimal price, String photoUrl, int version,String cuisine, int weight, String cafe, Integer cafeId)
		cq.multiselect(root.get("id"), root.get("title"), root.get("description"), root.get("price"), root.get("photoUrl"), root.get("version"), root.get("cuisine"), root.get("weight"), root.get("cafe"), root.get("cafeId"));		
		PredicateBuilder builder = new PredicateBuilder(filter, cb, root);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		cq.distinct(true);
		List<MealView> content = em.createQuery(cq)
				.setFirstResult(pageable.getPageNumber())
				.setMaxResults(pageable.getPageSize())
				.getResultList();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Meal> rootCount = cqCount.from(Meal.class);
		cqCount.select(cb.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(filter, cb, rootCount);
		Predicate predicateCount = builderCount.toPredicate();
		if(predicateCount!=null) cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
	
	private static class PredicateBuilder{
		
		final MealFilter filter;
		
		final CriteriaBuilder cb;
		
		final Root<Meal> root;
		
		final List<Predicate> predicates = new ArrayList<>();

		public PredicateBuilder(MealFilter filter, CriteriaBuilder cb, Root<Meal> root) {
			super();
			this.filter = filter;
			this.cb = cb;
			this.root = root;
		}
		
		void findByTitle() {
			if(!filter.getTitle().isEmpty()) {
				predicates.add(cb.like(root.get("title"), filter.getTitle()+"%"));
			}
		}
		
		void findByMinPrice() {
			if(!filter.getMinPrice().isEmpty()){
				predicates.add(cb.ge(root.get("price"), new BigDecimal(filter.getMinPrice())));
			}
		}
		
		void findByMaxPrice() {
			if(!filter.getMaxPrice().isEmpty()){
				predicates.add(cb.le(root.get("price"), new BigDecimal(filter.getMaxPrice())));
			}
		}
		
		void findByMinWeight() {
			if(!filter.getMinWeight().isEmpty()) {
				predicates.add(cb.ge(root.get("weight"), Integer.parseInt(filter.getMinWeight())));
			}
		}
		
		void findByMaxWeight() {
			if(!filter.getMaxWeight().isEmpty()) {
				predicates.add(cb.le(root.get("weight"), Integer.parseInt(filter.getMaxWeight())));
			}
		}
		
		void findByCuisisnes() {
			if(!filter.getCuisinesIds().isEmpty()){
				Join<Meal, Cuisine> join = root.join("cuisine");
				predicates.add(join.get("cuisine").in(filter.getCuisinesIds()));
			}
		}
		
		void findByCafes() {
			if(!filter.getCafes().isEmpty()){
				Join<Meal, Cafe> join = root.join("cafe");
				predicates.add(join.get("cafe").in(filter.getCafes()));
			}
		}
		
		void findByIngredients() {
			if(!filter.getIngredientsIds().isEmpty()){
				Join<Meal, Ingredient> join = root.join("ingredients");
				predicates.add(join.get("ingredients").in(filter.getIngredientsIds()));
			}
		}
	
		
		
		Predicate toPredicate() {
			findByTitle();
			findByMinPrice();
			findByMaxPrice();
			findByMinWeight();
			findByMaxWeight();
			findByCuisisnes();
			findByCafes();
			findByIngredients();
			return cb.and(predicates.stream().toArray(Predicate[]::new));
			}
	}
		
}
	



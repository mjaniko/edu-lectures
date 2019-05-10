package com.digitaledu.data.specification;

import com.digitaledu.model.AbstractEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericSpecification {


    /**
     * გაფილტრავს გადმოწოდებული ID ის მიხედვით
     *
     * @param id
     * @return
     */
    public static <T extends AbstractEntity> Specification<T> filterById(Long id) {
        return new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("id"), id)
                );
            }
        };
    }

    /**
     * ორ თარიღს შორის მომხმარებლების მოძებნა
     *
     * @param from
     * @param to
     * @return
     */
    public static <T extends AbstractEntity> Specification<T> filterRangeByDate(Date from, Date to) {
        return (Specification) (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            predicateList.add(criteriaBuilder.between(root.get("createdAt"), from, to));

            /*if (checkOnlyActives) {
                predicateList.add(criteriaBuilder.isTrue(root.get("active")));
            }*/
            // ROOT - კონკრეტული ობიექტი რომელზეც ვმუშაობთ

            //
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }
}

package com.springboot.advanced_jpa.data.repository;



import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    /*JPQL: JPA Query Language 의 줄임말로 JPA 에서 사용하는 쿼리를 의미한다.
    * ex) select p from Product p where p.number=?1;*/

    /* 쿼리 메서드: 메서드 이름을 분석해서 JPQL 쿼리 실행하는 메서드
     쿼리 메서드는 크게 동작을 결정하는 주제(Subject)와 서술어(Predicate)로 구분한다. 'find by','exists by'
    * 와 같은 키워드로 쿼리의 주제를 정하면 'by' 는 서술어의 시작을 나타내는 구분자 역할을 한다.*/
    /* 쿼리 메서드의 주제 부분에 사용할 수 있는 키워드
    * find, read, get, query, search, stream..*/

    // find by
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long number);

    // exists by
    boolean existsByNumber(Long number);

    // count by
    long countByName(String name);

    // delete by, remove by
    void deleteByNumber(Long number);
    long removeByName(String name);

    // First<number>, Top<number>
    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);

    // is,Equals
    Product findByNumberIs(Long number);
    Product findByNumberEquals(Long number);

    // (is)Not
    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long number);

    // (is)Null, (is)NotNull
    List<Product> findByUpdatedAtNull();
    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtNotNull();
    List<Product> findByUpdatedAtIsFalse();

    // And,Or
    Product findByNumberAndName(Long number,String name);
    Product findByNumberOrName(Long number,String name);

    // (is)GreaterThan,(is)LessThan,(is)Between
    List<Product> findByPriceIsGreaterThan(long price);
    List<Product> findByPriceIsLessThan(long price);
    List<Product> findByPriceIsBetween(Long lowPrice,long highPrice);

    List<Product> findByName(String name,Sort sort);


}

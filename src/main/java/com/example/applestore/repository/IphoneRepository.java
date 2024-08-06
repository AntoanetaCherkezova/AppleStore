package com.example.applestore.repository;
import com.example.applestore.model.entity.Iphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface IphoneRepository extends JpaRepository<Iphone, Long> {

    @Query("SELECT i FROM Iphone i ORDER BY i.internalMemory DESC")
    List<Iphone> findIphoneWithLargestMemory();

    @Query("SELECT i FROM Iphone i ORDER BY i.releaseDate DESC")
    List<Iphone>findLatestModelIphone();

    @Query(value = "SELECT * FROM i_phones ORDER BY registered_on DESC LIMIT 10", nativeQuery = true)
    List<Iphone> findLatestIphones();

    @Query(value = "SELECT * FROM i_phones ORDER BY warranty ASC LIMIT 5", nativeQuery = true)
    List<Iphone> findLongestWarrantyIphone();
}
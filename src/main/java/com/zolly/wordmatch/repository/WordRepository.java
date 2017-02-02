package com.zolly.wordmatch.repository;

import com.zolly.wordmatch.model.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by oliver on 31/01/17.
 */
@Repository
public interface WordRepository extends CrudRepository<Word, Long> {

    List<Word> findByGerman(String german);

    List<Word> findByEnglish(String english);



}

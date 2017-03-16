package com.zolly.wordmatch.rest.service;

import com.zolly.wordmatch.model.Word;

import java.util.List;

/**
 * Created by oliver on 02/02/17.
 */
public interface RestService {

    Iterable<Word> getAll();

    Word get(Long id);

    List<Word> getWords(int num);

    Word add(Word word);

    Word updateCorrect(Long id);

    Word updateIncorrect(Long id);

    void delete(Long id);
}

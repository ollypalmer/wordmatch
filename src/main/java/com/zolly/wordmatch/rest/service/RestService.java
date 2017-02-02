package com.zolly.wordmatch.rest.service;

import com.zolly.wordmatch.model.Word;

/**
 * Created by oliver on 02/02/17.
 */
public interface RestService {

    Iterable<Word> getAll();

    Word get(Long id);

    Word add(Word word);

    Word update(Long id, Word word);

    void delete(Long id);
}

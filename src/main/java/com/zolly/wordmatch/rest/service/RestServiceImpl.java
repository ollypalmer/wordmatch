package com.zolly.wordmatch.rest.service;

import com.zolly.wordmatch.model.Word;
import com.zolly.wordmatch.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by oliver on 31/01/17.
 */
@Service
public class RestServiceImpl implements RestService {

    private WordRepository wordRepository;

    @Autowired
    public RestServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Iterable<Word> getAll() {
        return wordRepository.findAll();
    }

    public Word get(Long id) {
        return wordRepository.findOne(id);
    }

    public Word add(Word word) {
        return wordRepository.save(word);
    }

    // TODO update update
    public Word update(Long id, Word update) {
        Word word = wordRepository.findOne(id);
        return wordRepository.save(word);
    }

    public void delete(Long id) {
        wordRepository.delete(id);
    }
}

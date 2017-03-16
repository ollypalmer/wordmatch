package com.zolly.wordmatch.rest.service;

import com.google.common.collect.Lists;
import com.zolly.wordmatch.model.Word;
import com.zolly.wordmatch.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Word> getWords(int num) {
        List<Word> words = Lists.newArrayList(getAll());
        int size = words.size();
        if (num < words.size()) {
            size = num;
        }
        Collections.shuffle(words);
        return words.subList(0, size);
    }

    public Word add(Word word) {
        return wordRepository.save(word);
    }

    public Word updateCorrect(Long id) {
        Word word = wordRepository.findOne(id);
        word.setCorrect(word.getCorrect() + 1);
        return wordRepository.save(word);
    }

    public Word updateIncorrect(Long id) {
        Word word = wordRepository.findOne(id);
        word.setIncorrect(word.getIncorrect() + 1);
        return wordRepository.save(word);
    }

    public void delete(Long id) {
        wordRepository.delete(id);
    }
}

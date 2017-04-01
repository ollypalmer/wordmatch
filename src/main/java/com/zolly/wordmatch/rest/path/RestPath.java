package com.zolly.wordmatch.rest.path;

import com.zolly.wordmatch.model.Word;
import com.zolly.wordmatch.rest.service.RestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by oliver on 31/01/17.
 */
@RestController
public class RestPath {

    private RestService restService;

    public RestPath(RestService restService) {
        this.restService = restService;
    }

    @RequestMapping( value = "/getAll", method = RequestMethod.GET)
    public Iterable<Word> getAll() {
        return restService.getAll();
    }

    @RequestMapping( value = "/get/{id}", method = RequestMethod.GET)
    public Word get(@PathVariable(value = "id") Long id) {
        return restService.get(id);
    }

    @RequestMapping( value = "/getWords/{num}", method = RequestMethod.GET)
    public List<Word> getWords(@PathVariable(value = "num") int num) {
        return restService.getWords(num);
    }

    @RequestMapping( value = "/getIncorrectWords/{num}", method = RequestMethod.GET)
    public List<Word> getSortedWords(@PathVariable(value = "num") int num) {
        return restService.getSortedWords(num);
    }

    @RequestMapping( value = "/addWord", method = RequestMethod.POST)
    public Word addWord(@RequestBody Word word) {
        return restService.add(word);
    }

    @RequestMapping( value = "/updateCorrect/{id}", method = RequestMethod.GET)
    public Word updateCorrect(@PathVariable(value = "id") Long id) {
        return restService.updateCorrect(id);
    }

    @RequestMapping( value = "/updateIncorrect/{id}", method = RequestMethod.GET)
    public Word updateIncorrect(@PathVariable(value = "id") Long id) {
        return restService.updateIncorrect(id);
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value = "id") Long id) {
        restService.delete(id);
    }
}

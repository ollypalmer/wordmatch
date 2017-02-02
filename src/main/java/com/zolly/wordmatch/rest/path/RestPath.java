package com.zolly.wordmatch.rest.path;

import com.zolly.wordmatch.model.Word;
import com.zolly.wordmatch.rest.service.RestService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping( value = "/addWord", method = RequestMethod.POST)
    public Word addWord(@RequestBody Word word) {
        return restService.add(word);
    }

    @RequestMapping( value = "/update/{id}", method = RequestMethod.PUT)
    public Word update(@PathVariable(value = "id") Long id, @RequestBody Word word) {
        return restService.update(id, word);
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value = "id") Long id) {
        restService.delete(id);
    }
}

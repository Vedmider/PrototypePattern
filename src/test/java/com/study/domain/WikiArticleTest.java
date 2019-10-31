package com.study.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WikiArticleTest {
    private WikiArticle wikiArticle;
    private WikiArticle clonedArticle;

    @Before
    public void setUp(){
        wikiArticle = new WikiArticle();
        wikiArticle.setTitle("Space programs");
        wikiArticle.setArticleStrings(Arrays.asList("X-15 rocket plane", "Project Mercury", "Project Gemini"));
        clonedArticle = wikiArticle.clone();
    }

    @Test
    public void shouldReturnEqualObjectAfterCloning(){
        assertEquals(wikiArticle, clonedArticle);
    }

    @Test
    public void linksOfClonedAndOriginalObjectsShouldNotBeTheSame(){
        assertFalse(wikiArticle == clonedArticle);
    }

    @Test
    public void shouldNotBeEqualsAfterEditingClonedObject(){
        clonedArticle.setTitle("Title");
        clonedArticle.setArticleStrings(Arrays.asList("Some text"));
        assertNotEquals(wikiArticle, clonedArticle);
    }

}

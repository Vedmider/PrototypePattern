package com.study.domain;

import java.io.*;
import java.util.List;

public class WikiArticle implements Serializable, CloneWikiArticle {
    private List<String> articleStrings;
    private String title;
    private List<WikiArticle> linkedWikiArticles;


    public void setArticleStrings(List<String> articleStrings) {
        this.articleStrings = articleStrings;
        System.out.println(" Setting article Strings to " + articleStrings);
    }

    public void setLinkedWikiArticles(List<WikiArticle> linkedWikiArticles) {
        this.linkedWikiArticles = linkedWikiArticles;
        System.out.println("Setting linked wiki articles to " + linkedWikiArticles);
    }

    public void setTitle(String title) {
        this.title = title;
        System.out.println("Setting title to " + title);
    }

    public List<String> getArticleStrings() {
        return articleStrings;
    }

    public List<WikiArticle> getLinkedWikiArticles() {
        return linkedWikiArticles;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public WikiArticle clone() {
        WikiArticle clonedArticle = null;
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(this);
            objectStream.close();
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            clonedArticle = (WikiArticle) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Can not clone object ");
        } catch (ClassNotFoundException e) {
            System.out.println("Can not find class WikiArticle");
        }
        System.out.println("Successfully cloned");
        return clonedArticle;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        WikiArticle wikiArticle = (WikiArticle) obj;
        return title.equals(wikiArticle.getTitle())
                && articleStrings.equals(wikiArticle.getArticleStrings())
                && (linkedWikiArticles == wikiArticle.getLinkedWikiArticles()
                    || (linkedWikiArticles != null
                        && wikiArticle.getLinkedWikiArticles() != null
                        && linkedWikiArticles.equals(wikiArticle.getLinkedWikiArticles())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((linkedWikiArticles == null) ? 0 : linkedWikiArticles.hashCode());
        result = prime * result + ((articleStrings == null) ? 0 : articleStrings.hashCode());
        return result;
    }
}

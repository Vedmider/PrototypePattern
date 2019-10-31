package com.study.domain;

import java.util.Arrays;

public class Editor {
    private WikiArticle currentVersion;
    private WikiArticle originalVersion;

    public WikiArticle editArticle(WikiArticle wikiArticle){
        currentVersion = wikiArticle.clone();
        originalVersion = wikiArticle.clone();

        currentVersion.setArticleStrings(Arrays.asList("Ones upon a time", "Somewhere, hidden amongst thorny brambles", "There was a little kingdom", "Ben and Holly little kingdom"));
        currentVersion.setTitle("Ben and Holly little kingdom");
        WikiArticle temp = new WikiArticle();
        temp.setTitle("Kingdoms");
        currentVersion.setLinkedWikiArticles(Arrays.asList(temp));

        return wikiArticle;
    }

    public WikiArticle revertCurrentChanges(){
        return originalVersion;
    }

    public WikiArticle getCurrentVersion() {
        return currentVersion;
    }
}

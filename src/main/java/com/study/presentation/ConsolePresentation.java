package com.study.presentation;

import com.study.domain.Editor;
import com.study.domain.WikiArticle;

import java.util.Arrays;

public class ConsolePresentation {
    public static void main(String[] args) {
        System.out.println("Prototype demonstration\n\n.....\n\n");


        WikiArticle wikiArticle = new WikiArticle();
        wikiArticle.setTitle("Space programs");
        wikiArticle.setArticleStrings(Arrays.asList("X-15 rocket plane", "Project Mercury", "Project Gemini"));
        Editor editor = new Editor();
        WikiArticle editedArticle = editor.editArticle(wikiArticle);
        WikiArticle originalArticle = editor.revertCurrentChanges();

        System.out.println(" WikiArticle after changes is not equal to edited variant : " + wikiArticle.equals(editedArticle));
        System.out.println(" WikiArticle equals to edited article after reverting changes : " + wikiArticle.equals(originalArticle));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;

import java.util.LinkedList;

/**
 *
 * @author Alex Vasil
 */
public class Highscores {

    private String name;
    private int score;

    private LinkedList<Highscores> scoreList;

    public Highscores() {

    }

    public Highscores(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void insert(String name, int score) {
        if (scoreList == null) {
            scoreList = new LinkedList<>();
            scoreList.add(new Highscores(name, score));
            return;
        }

        int previousScore = 0;
        if (scoreList.size() != 10) {
            addElement(score, name, previousScore);
        } else {
            scoreList.removeLast();
            addElement(score, name, previousScore);
        }
    }

    private void addElement(int score, String name, int previousScore) {
        //Add the element to the end of the list.
        if (score < scoreList.getLast().score) {
            scoreList.addLast(new Highscores(name, score));
        //Add the element to the beginning of the list.    
        } else if (score > scoreList.getFirst().score) {
            scoreList.addFirst(new Highscores(name, score));
        //Add the element anywhere between the first and last elements.
        } else {
            for (int i = 0; i < scoreList.size(); i++) {
                if (previousScore >= score && scoreList.get(i).score <= score) {
                    scoreList.add(i, new Highscores(name, score));
                    break;
                }
                previousScore = scoreList.get(i).score;
            }
        }
    }

    public void printScoreNameList() {
        scoreList.stream().forEach(e -> System.out.println(e.name + ", " + e.score));
    }
}

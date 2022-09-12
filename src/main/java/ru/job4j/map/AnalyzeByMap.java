package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                count++;
                score += subject.score();
            }
        }
        return score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        double score = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                count++;
                score += subject.score();
            }
            result.add(new Label(pupil.name(), score / count));
            score = 0;
            count = 0;
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (temp.containsKey(subject.name())) {
                    temp.put(subject.name(), subject.score() + temp.get(subject.name()));
                    } else {
                    temp.put(subject.name(), subject.score());
                }
            }
        }
        for (Map.Entry<String, Integer> map : temp.entrySet()) {
            String name = map.getKey();
            int value = map.getValue();
            result.add(new Label(name, value / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {

        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
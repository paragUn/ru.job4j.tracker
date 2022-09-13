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
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.merge(subject.name(), subject.score(), (a, b) -> b + temp.get((subject.name())));
            }
        }
        for (Map.Entry<String, Integer> map : temp.entrySet()) {
            result.add(new Label(map.getKey(), map.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            result.add(new Label(pupil.name(), score));
            score = 0;
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
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
            result.add(new Label(map.getKey(), map.getValue()));
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }
}
package com.latam.covid.utils;

import com.latam.covid.Enum.Covid;
import com.latam.covid.models.EQuestions;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import Utils.GlobalVars;

public class Validation {

    public int MAX = 4;


    public Covid isCovid(List<EQuestions> questions) {

        AtomicReference<Covid> sickness = new AtomicReference<>(Covid.SANO);
        AtomicInteger count = new AtomicInteger(0);

        Optional.ofNullable(questions).ifPresent(list -> {

            list.stream().forEach(q -> {
                if (q.isChecked() && !q.isCovid19()) {
                    sickness.set(Covid.RESFRIADO);
                    return;
                } else if (q.isChecked() && q.isCovid19()) {
                    if (count.incrementAndGet() == MAX) {
                        sickness.set(Covid.COVID);
                        return;
                    }
                    sickness.set(Covid.RESFRIADO);
                }

            });


        });

        GlobalVars.DiAGNOSTIC = sickness.get();
        return sickness.get();
    }


}

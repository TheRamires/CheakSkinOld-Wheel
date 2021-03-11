package com.example.cheakskin.ui.home.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class HomeRepositoriy {
    public Single<List<LPU>> getLPU(){
        //example
        LPU lpu=new LPU(4.1, "г.Горно-Алтайск, ул. Мир1", "ГБУЗ \"Поликлиника кожаных заболеваний\"",
                "+632363623","Оказывает высокотехнологическую мед помощь",
                "График работы: Пн-Пт 9:00-18:00 \n \b Сб-Вс выходной",
                "email: example.com");
        List<LPU> list=new ArrayList<>();
        list.add(lpu);
        list.add(lpu);
        list.add(lpu);
        return Single.just(list);
    }
    public Single<List<ReviewEntity>> getReviews(){
        //example
        ReviewEntity review=new ReviewEntity(1, 4,"Алена",
                "Поликлиника очень хорошая! Врачи компитенты","05,02,221");
        ReviewEntity review2=new ReviewEntity(1, 4.5,"Алена",
                "Поликлиника неплохая! Врачи компитенты","05,02,221");
        ReviewEntity review3=new ReviewEntity(1, 4.5,"Алена",
                "Поликлиника очень хорошая! Врачи компитенты","06,02,221");
        ReviewEntity review4=new ReviewEntity(1, 4.1,"Алена",
                "Поликлиника хорошая! Врачи компитенты","08,02,221");
        ReviewEntity review5=new ReviewEntity(1, 4.1,"Федор",
                "Поликлиника хорошая! Врачи компитенты","02,02,221");
        List<ReviewEntity> list=new ArrayList<>();
        list.add(review);
        list.add(review2);
        list.add(review3);
        list.add(review4);
        list.add(review5);
        Collections.sort(list, new Comparator<ReviewEntity>() {
            @Override
            public int compare(ReviewEntity o1, ReviewEntity o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        return Single.just(list);
    }
}

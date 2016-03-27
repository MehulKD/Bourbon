package com.hitherejoe.bourbon.data;

import com.hitherejoe.bourbon.common.data.model.Comment;
import com.hitherejoe.bourbon.common.data.model.Shot;
import com.hitherejoe.bourbon.data.remote.BourbonService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Single;

@Singleton
public class DataManager {

    private final BourbonService mBourbonService;

    @Inject
    public DataManager(BourbonService bourbonService) {
        mBourbonService = bourbonService;
    }

    public Single<List<Shot>> getShots(int perPage, int page) {
        return mBourbonService.getShots(com.hitherejoe.bourbon.BuildConfig.DRIBBBLE_ACCESS_TOKEN,
                perPage,
                page);
    }

    public Single<List<Comment>> getComments(int id) {
        return mBourbonService.getComments(id, com.hitherejoe.bourbon.BuildConfig.DRIBBBLE_ACCESS_TOKEN);
    }
}
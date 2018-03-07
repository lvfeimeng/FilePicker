package com.imlibo.filepicker;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.imlibo.filepicker.util.FileUtils;
import com.imlibo.filepicker.util.MimeType;

import java.util.Set;

/**
 * SelectOptions
 * Created by 李波 on 2018/3/7.
 */

public class SelectOptions {

    public static final String CHOOSE_TYPE_BROWSER = "choose_type_browser";
    public static final String CHOOSE_TYPE_SCAN = "choose_type_scan";
    public static final String CHOOSE_TYPE_MEDIA = "choose_type_media";

    public String[] mFileTypes;
    public String mSortType;
    public boolean isSingle = false;
    public int maxCount = 10;
    public int request_code;
    public boolean onlyShowImages = false;
    public boolean onlyShowVideos = false;
    public boolean enabledCapture = false;
    public Drawable placeHolder;
    public Set<MimeType> mimeTypeSet;

    public String[] getFileTypes() {
        if(mFileTypes == null || mFileTypes.length == 0){
            return new String[]{};
        }
        return mFileTypes;
    }

    public int getSortType() {
        if(TextUtils.isEmpty(mSortType)){
            return FileUtils.BY_NAME_ASC;
        }
        return Integer.valueOf(mSortType);
    }

    public void setSortType(int sortType){
        mSortType = String.valueOf(sortType);
    }

    public static SelectOptions getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static SelectOptions getCleanInstance() {
        SelectOptions options = getInstance();
        options.reset();
        return options;
    }

    private void reset(){
        mFileTypes = new String[]{};
        mSortType = String.valueOf(FileUtils.BY_NAME_ASC);
        isSingle = false;
        maxCount = 10;
        onlyShowImages = false;
        onlyShowVideos = false;
        enabledCapture = false;
    }

    private static final class InstanceHolder {
        private static final SelectOptions INSTANCE = new SelectOptions();
    }

}
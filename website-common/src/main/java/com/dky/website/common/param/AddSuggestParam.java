package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;

/**
 * Created by wonpera on 2017/2/24.
 */
public class AddSuggestParam extends BaseParameter {

    private String name;

    private String title;

    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

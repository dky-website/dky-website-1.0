package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by wonpera on 2017/2/24.
 */
public class AddFrontSuggestParam extends BaseParameter {


    @NotBlank(message = "名称不能为空")
    private String name;

    @NotBlank(message = "标题不能为空")
    private String title;

    @NotBlank(message = "内容不能为空")
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

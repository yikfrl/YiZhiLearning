package com.yz.yikfrl.yizhilearning.model.bean.wangyi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangz on 2018/3/1.
 * 新闻详情实体类
 */

public class WangyiNewsDetailBean implements Serializable{
    @SerializedName("docid")
    private String docid;
    @SerializedName("title")
    private String title;
    @SerializedName("source")
    private String source;
    @SerializedName("body")
    private String body;
    @SerializedName("ptime")
    private String ptime;
    @SerializedName("cover")
    private String cover;
    /**
     * 图片列表
     */
    @SerializedName("imgList")
    private List<String> imgList;
    @SerializedName("shareLink")
    private String shareLink;

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }
}

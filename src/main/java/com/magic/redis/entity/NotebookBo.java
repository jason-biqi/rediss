package com.magic.redis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("笔记包内 notebook.dat")
public class NotebookBo {

    @ApiModelProperty("笔记本本地Id")
    private Long notebookId;


    @ApiModelProperty("笔记本服务器Id")
    private Long notebookServerId;

    @ApiModelProperty("笔记本标题")
    private String notebookTitle;

    @ApiModelProperty("笔记本描述")
    private String notebookDesc;

    @ApiModelProperty("模板Id")
    private Long templateId;

    @ApiModelProperty("模板类型")
    private Integer templateType;

    @ApiModelProperty("1横屏/2竖屏")
    private Byte orientation;

    @ApiModelProperty("最后停留的页Id")
    private String lastNotepageId;

    @ApiModelProperty("总页数")
    private Integer pageCount;


    @ApiModelProperty("笔记页数组")
    private List<NotePageBo> notepages = new ArrayList<>();


    @ApiModelProperty("设备Id")
    private String deviceId;

    @ApiModelProperty("设备类型：AndroidPhone/ AndroidPad")
    private String deviceType;

    @ApiModelProperty("设备分辨率：格式：宽度x高度，单位：像素")
    private String resolution;

    @ApiModelProperty("系统版本")
    private String osVersion;

    @ApiModelProperty("笔记本版本：格式：主版本号.子版本号，从1.0开始")
    private String version;

    @ApiModelProperty("应用版本：格式：主版本号.子版本号.修正版本号")
    private String clientVersion;

    @ApiModelProperty("创建人id")
    private String userId;

    @ApiModelProperty("创建时间戳，单位：毫秒")
    private Long createTime;

    @ApiModelProperty("更新时间戳，单位：毫秒")
    private Long updateTime;

    @ApiModelProperty("文档类型：10：笔记本，11：作业本，12：答题卷，13：错题本，14：草稿本")
    private Integer docType;

    @ApiModelProperty("学科Id")
    private String subjectId;


    @ApiModelProperty("作业id")
    private String taskId;


    @ApiModelProperty("当前页索引")
    private Integer currentPageIndex;


    public void setNotepages(List<NotePageBo> notepages) {
        int index = 1;
        for (NotePageBo page : notepages) {
            page.setPageNum(index);
            index ++;
        }
        this.notepages = notepages;
    }

    @Override
    public String toString() {
        return "NotebookBo{" +
                "notebookId=" + notebookId +
                ", notebookServerId=" + notebookServerId +
                ", notebookTitle='" + notebookTitle + '\'' +
                ", notebookDesc='" + notebookDesc + '\'' +
                ", templateId=" + templateId +
                ", templateType=" + templateType +
                ", orientation=" + orientation +
                ", lastNotepageId='" + lastNotepageId + '\'' +
                ", pageCount=" + pageCount +
                ", notepages=" + notepages +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", resolution='" + resolution + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", version='" + version + '\'' +
                ", clientVersion='" + clientVersion + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", docType=" + docType +
                ", subjectId='" + subjectId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", currentPageIndex=" + currentPageIndex +
                '}';
    }
}

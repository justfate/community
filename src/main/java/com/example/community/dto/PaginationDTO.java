package com.example.community.dto;

import java.util.List;

/**
 * @Project: community
 * @ClassName: PagirationDTO
 * @Company: JIT Northeast R & D
 * @Description:
 * @author: zheng_wang
 * @date: 2020年03月26日
 */
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    /*分页列表*/
    private List<Integer> pages;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        Integer totalPage;
        if(totalCount % size ==0){
            totalPage = totalCount % size;
        }else{
            totalPage = totalCount % size+1;
        }
        pages.add(page);
        for (int i=0;i<3;i++){
            if(page-i>0){
                pages.add(page-i,0);
            }

            if(page+i <= totalCount){
                pages.add(page+i);
            }
        }

        /*是否展示上一页*/
        if(page ==1){
            showPrevious = false;
        }else{
            showPrevious = true;
        }
        /*是否展示下一页*/
        if(page.equals(totalPage)){
            showNext = false;
        }else{
            showNext = true;
        }

        /*是否展示第一页*/
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }

        /*是否展示最后一页*/
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowFirstPage() {
        return showFirstPage;
    }

    public void setShowFirstPage(boolean showFirstPage) {
        this.showFirstPage = showFirstPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }
}

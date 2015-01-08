package pl.ebla.mjbx.wapper;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageWrapper<T> {
    public static final int MAX_PAGE_ITEM_DISPLAY = 5;
    private Page<T> page;
    private List<T> items;
    private int currentNumber;
    private String url; 
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PageWrapper(Page<T> page, String url){
      
    	this.page = page;
        this.url = url;
        currentNumber = page.getNumber() ; 
        items = page.getContent();

    }

    public List<T> getItems(){
        return items;
    }

    public int getNumber(){
        return currentNumber;
    }

    public int getSize(){
        return page.getSize();
    }

    public int getTotalPages(){
        return page.getTotalPages();
    }

    public boolean isFirstPage(){
        return page.isFirst();
    }

    public boolean isLastPage(){
        return page.isLast();
    }

    public boolean isHasPreviousPage(){
        return page.hasPrevious();
    }

    public boolean isHasNextPage(){
        return page.hasNext();
    }
}
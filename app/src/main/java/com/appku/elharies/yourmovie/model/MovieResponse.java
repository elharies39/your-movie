
package com.appku.elharies.yourmovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

//@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MovieResponse {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private ArrayList<Result> mResults;
    @SerializedName("total_pages")
    private Long mTotalPages;
    @SerializedName("total_results")
    private Long mTotalResults;

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public ArrayList<Result> getResults() {
        return mResults;
    }

    public void setResults(ArrayList<Result> results) {
        mResults = results;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Long totalResults) {
        mTotalResults = totalResults;
    }

}

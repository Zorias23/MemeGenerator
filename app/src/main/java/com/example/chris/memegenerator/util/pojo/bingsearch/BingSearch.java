
package com.example.chris.memegenerator.util.pojo.bingsearch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BingSearch {

    @SerializedName("_type")
    @Expose
    private String type;
    @SerializedName("instrumentation")
    @Expose
    private Instrumentation instrumentation;
    @SerializedName("readLink")
    @Expose
    private String readLink;
    @SerializedName("webSearchUrl")
    @Expose
    private String webSearchUrl;
    @SerializedName("totalEstimatedMatches")
    @Expose
    private Integer totalEstimatedMatches;
    @SerializedName("nextOffset")
    @Expose
    private Integer nextOffset;
    @SerializedName("value")
    @Expose
    private List<Value> value = null;
    @SerializedName("queryExpansions")
    @Expose
    private List<QueryExpansion> queryExpansions = null;
    @SerializedName("pivotSuggestions")
    @Expose
    private List<PivotSuggestion> pivotSuggestions = null;
    @SerializedName("similarTerms")
    @Expose
    private List<SimilarTerm> similarTerms = null;
    @SerializedName("relatedSearches")
    @Expose
    private List<RelatedSearch> relatedSearches = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }

    public void setInstrumentation(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    public String getReadLink() {
        return readLink;
    }

    public void setReadLink(String readLink) {
        this.readLink = readLink;
    }

    public String getWebSearchUrl() {
        return webSearchUrl;
    }

    public void setWebSearchUrl(String webSearchUrl) {
        this.webSearchUrl = webSearchUrl;
    }

    public Integer getTotalEstimatedMatches() {
        return totalEstimatedMatches;
    }

    public void setTotalEstimatedMatches(Integer totalEstimatedMatches) {
        this.totalEstimatedMatches = totalEstimatedMatches;
    }

    public Integer getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(Integer nextOffset) {
        this.nextOffset = nextOffset;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    public List<QueryExpansion> getQueryExpansions() {
        return queryExpansions;
    }

    public void setQueryExpansions(List<QueryExpansion> queryExpansions) {
        this.queryExpansions = queryExpansions;
    }

    public List<PivotSuggestion> getPivotSuggestions() {
        return pivotSuggestions;
    }

    public void setPivotSuggestions(List<PivotSuggestion> pivotSuggestions) {
        this.pivotSuggestions = pivotSuggestions;
    }

    public List<SimilarTerm> getSimilarTerms() {
        return similarTerms;
    }

    public void setSimilarTerms(List<SimilarTerm> similarTerms) {
        this.similarTerms = similarTerms;
    }

    public List<RelatedSearch> getRelatedSearches() {
        return relatedSearches;
    }

    public void setRelatedSearches(List<RelatedSearch> relatedSearches) {
        this.relatedSearches = relatedSearches;
    }

}

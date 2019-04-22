package prakratisharma.nycschools.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SchoolDetails implements Serializable {

    @SerializedName("school_name")
    private String name;

    @SerializedName("num_of_sat_test_takers")
    private String testTakers;

    @SerializedName("sat_critical_reading_avg_score")
    private String readingScore;

    public String getMathScore() {
        return mathScore;
    }

    @SerializedName("sat_math_avg_score")
    private String mathScore;

    @SerializedName("sat_writing_avg_score")
    private String writingScore;

    public SchoolDetails()
    {}
    public SchoolDetails(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestTakers() {
        return testTakers;
    }

    public void setTestTakers(String testTakers) {
        this.testTakers = testTakers;
    }

    public String getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(String readingScore) {
        this.readingScore = readingScore;
    }



    public void setMathScore(String mathScore) {
        this.mathScore = mathScore;
    }

    public String getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(String writingScore) {
        this.writingScore = writingScore;
    }




}

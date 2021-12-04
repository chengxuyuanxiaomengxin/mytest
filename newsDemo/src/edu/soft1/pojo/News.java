package edu.soft1.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor


public class News {
    private String nId,nTid,nTitle,nAuthor,nCreateDate,nPicPath,nContent,nModifyDate,nSummary;

//    public String getnTitle() {
//        return nTitle;
//    }
}

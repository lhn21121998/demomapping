package com.test.capstone.testcapstone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postId;

    public Comment() {
    }

    public Comment(int commentId, String content, Date createDate, Date updateDate, Post postId) {
        this.commentId = commentId;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.postId = postId;
    }

    public Comment(int commentId, String content, Date createDate, Date updateDate) {
        this.commentId = commentId;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

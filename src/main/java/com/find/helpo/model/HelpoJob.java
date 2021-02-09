package com.find.helpo.model;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "helpo_job", schema = "public")
@Transactional
public class HelpoJob {

    //TO-DO correct sequence generation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "helpo_job_id")
    private Integer helpoJobID;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "job_post_date")
    private String jobPostDate;
    @Column(name = "job_type")
    private String jobType;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "job_reward")
    private String jobReward;
    @Column(name = "job_status")
    private String jobStatus;
    @Column(name = "job_owner_id")
    private Integer jobOwnerID;
    @Column(name = "job_favored_status")
    private String jobFavoredStatus;
    @Column(name = "job_favored_by_user_id")
    private Integer jobFavoredByUserId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "helpo_user_id", referencedColumnName = "helpo_user_id")
    private HelpoUser helpoUser;

    @OneToMany(mappedBy = "helpoJobPhotos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HelpoJobPhoto> helpoJobPhotoList;




}

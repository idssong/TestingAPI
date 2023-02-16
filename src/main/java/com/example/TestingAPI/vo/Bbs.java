package com.example.TestingAPI.vo;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
    name = "BBS_ID_SEQ_GENERATOR"
    , sequenceName = "BBS_ID_SEQ"
    , initialValue = 32
    , allocationSize = 1
)
public class Bbs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BBS_ID_SEQ_GENERATOR")
    private Integer id;
    @Column
    private String title;
    @Column(columnDefinition = "TEXT")
    private String postText;
    @Column
    private String regUser;
    @CreationTimestamp
    @Column
    private LocalDateTime regDate;
    @Column
    private String modUser;
    @UpdateTimestamp
    @Column
    private LocalDateTime modDate;

}

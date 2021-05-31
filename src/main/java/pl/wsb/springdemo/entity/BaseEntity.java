package pl.wsb.springdemo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    private final String uuid = UUID.randomUUID().toString();

    @Version
    @Column(name = "Version", columnDefinition = "integer DEFAULT 0", nullable = false)
    protected long version = 0L;

//    @CreatedDate
//    @Column(name = "CreatedDate")
//    protected LocalDateTime createdDate;
//
//    @CreatedBy
//    @Column(name = "CreatedBy")
//    protected String createdBy;
//
//    @LastModifiedDate
//    @Column(name = "LastModifiedDate")
//    protected LocalDateTime lastModifiedDate;
//
//    @LastModifiedBy
//    @Column(name = "LastModifiedBy")
//    protected String lastModifiedBy;

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object that) {
        return (this == that) || that instanceof BaseEntity && Objects.equals(uuid, ((BaseEntity) that).uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}

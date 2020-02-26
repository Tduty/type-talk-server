package info.tduty.typetalkserver.data.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private Boolean enabled;

    @Column(name="sex")
    private String sex;

    @Column(name="teacher")
    private Boolean teacher;

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private Set<MessageEntity> messages;

    @ManyToMany(mappedBy="chatMembers", fetch = FetchType.EAGER)
    private Set<ChatEntity> chats;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClassEntity classEntity;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "UserCompleted_to_Lesson",
            joinColumns = { @JoinColumn(name = "ID_USER") },
            inverseJoinColumns = { @JoinColumn(name = "ID_LESSON_COMPLETED") }
    )
    private Set<LessonEntity> completedLessons;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "UserExecute_to_Lesson",
            joinColumns = { @JoinColumn(name = "ID_USER") },
            inverseJoinColumns = { @JoinColumn(name = "ID_LESSON_EXECUTE") }
    )
    private Set<LessonEntity> executeLessons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(Boolean teacher) {
        this.teacher = teacher;
    }

    public Set<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageEntity> messages) {
        this.messages = messages;
    }

    public Set<ChatEntity> getChats() {
        return chats;
    }

    public void setChats(Set<ChatEntity> chats) {
        this.chats = chats;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public Set<LessonEntity> getCompletedLessons() {
        return completedLessons;
    }

    public void setCompletedLessons(Set<LessonEntity> completedLessons) {
        this.completedLessons = completedLessons;
    }

    public Set<LessonEntity> getExecuteLessons() {
        return executeLessons;
    }

    public void setExecuteLessons(Set<LessonEntity> executeLessons) {
        this.executeLessons = executeLessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
        if (messages != null ? !messages.equals(that.messages) : that.messages != null) return false;
        if (chats != null ? !chats.equals(that.chats) : that.chats != null) return false;
        if (classEntity != null ? !classEntity.equals(that.classEntity) : that.classEntity != null) return false;
        if (completedLessons != null ? !completedLessons.equals(that.completedLessons) : that.completedLessons != null)
            return false;
        return executeLessons != null ? executeLessons.equals(that.executeLessons) : that.executeLessons == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        result = 31 * result + (chats != null ? chats.hashCode() : 0);
        result = 31 * result + (classEntity != null ? classEntity.hashCode() : 0);
        result = 31 * result + (completedLessons != null ? completedLessons.hashCode() : 0);
        result = 31 * result + (executeLessons != null ? executeLessons.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", sex='" + sex + '\'' +
                ", teacher=" + teacher +
                ", messages=" + messages +
                ", chats=" + chats +
                ", classEntity=" + classEntity +
                ", completedLessons=" + completedLessons +
                ", executeLessons=" + executeLessons +
                '}';
    }
}

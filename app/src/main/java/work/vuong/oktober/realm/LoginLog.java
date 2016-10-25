package work.vuong.oktober.realm;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by oberon (vuongpham) on 25/10/2016.
 *
 * Item to log logins
 */
public class LoginLog extends RealmObject{

    @PrimaryKey
    private long id;
    private Date timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

package com.nayidisha.slowglow.mongo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

public abstract class AbstractDocument {
    @Id
    private String id;

    private DateTime createdDate;

    private DateTime lastUpdate;

    public AbstractDocument() {

    }

    public AbstractDocument(AbstractDocument doc) {
        id = doc.id;
        createdDate = doc.createdDate;
        lastUpdate = doc.lastUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public DateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(DateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getIdAsString() {
        String result = null;

        if (id != null) {
            result = id.toString();
        }

        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createdDate", createdDate)
                .append("lastUpdate", lastUpdate)
                .toString();
    }
}

package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create (TimeEntry timeEntry);
    public TimeEntry update (long id, TimeEntry timeEntry);
    public TimeEntry find (long id);
    public void delete (long id);
    List<TimeEntry> list();
}

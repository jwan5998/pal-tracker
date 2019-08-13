package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    //TimeEntry timeEntry;
    Map<Long, TimeEntry> timeEntries;
    long maxId;
    //List<TimeEntry> timeEntries;

    public InMemoryTimeEntryRepository(){
        timeEntries = new HashMap<>();
        maxId = 0;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = ++this.maxId;
        TimeEntry timeEntryToCreate = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntries.put(id, timeEntryToCreate);
        return timeEntryToCreate;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry timeEntryToUpdate = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        if(timeEntries.containsKey(id)){
            timeEntries.put(id, timeEntryToUpdate);
            return timeEntryToUpdate;
        } else {
            return null;
        }
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }
}

package com.example.cbanda.achieve;


import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.db.GoalDao;
import com.example.cbanda.achieve.models.repository.GoalRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class GoalRepositoryImplTest {

    @Mock
    private GoalDao goalDao;
    @Mock
    private GoalRepository mockRepository;
    // private InsertAsyncTask insertAsyncTask;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void addGoal_TriggersDbAdd() {
        Goal goal = FakeGoalDataGenerator.INSTANCE.getFakeGoal();
        mockRepository.addGoal(goal);
        verify(mockRepository).addGoal(goal);
    }
}

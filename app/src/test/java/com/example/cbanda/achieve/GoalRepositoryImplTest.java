package com.example.cbanda.achieve;


import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.db.GoalDao;
import com.example.cbanda.achieve.models.repository.GoalRepository;
import com.example.cbanda.achieve.models.repository.GoalRepositoryImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class GoalRepositoryImplTest {

    @Mock
    private GoalDao goalDao;

    private GoalRepository goalRepository;
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        goalRepository = new GoalRepositoryImpl(goalDao);

    }

    @Test
    public void addGoal_TriggersDbAdd() {
        Goal goal = FakeGoalDataGenerator.getFakeGoal();
        goalRepository.addGoal(goal).test();
        verify(goalDao).addGoal(goal);
    }


  /*  @Test
    public void addGoal_getGoalList_Mutable() throws InterruptedException {
        MutableLiveData<List<Goal>> fakeGoalData = FakeGoalDataGenerator.getGoalListMutableData();
        when(goalDao.getListGoals()).thenReturn(fakeGoalData);

        List<Goal> goalsReturned = LiveDataTestUtil.getValue(goalRepository.getListGoals());

        verify(goalDao).getListGoals();
        assertArrayEquals(fakeGoalData.getValue().toArray(), goalsReturned.toArray());
    }*/


}

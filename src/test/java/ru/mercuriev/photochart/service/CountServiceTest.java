package ru.mercuriev.photochart.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.mercuriev.photochart.domain.Count;
import ru.mercuriev.photochart.domain.CountRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Eugene on 17.08.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class CountServiceTest {

    @Mock
    ProcessExecutor executor;

    @Mock
    CountRepository repository;

    @InjectMocks
    CountService countService;

    @Test
    public void testList() throws Exception {
        when(executor.execute(anyString())).thenReturn("12");
        List<Count> list = countService.list();
        Assert.assertEquals(list, new ArrayList<Count>());
    }

    @Test
    public void testPopulateNewCount() throws Exception {

    }
}
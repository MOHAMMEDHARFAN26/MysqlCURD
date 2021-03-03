package guru.springframework.repositories;

import guru.springframework.domain.ClassMo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClassMoRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private static final int CLASSMO_AGE = 5;


    @Autowired
    private ClassMoRepository classmoRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        ClassMo classmo = new ClassMo();
        classmo.setAge(CLASSMO_AGE);

        //when
        classmoRepository.save(classmo);

        //then
        Assert.assertNotNull(classmo.getId());
        ClassMo newClassMo = classmoRepository.findById(classmo.getId()).orElse(null);
        Assert.assertEquals((Long) 1L, newClassMo.getId());
        Assert.assertEquals(CLASSMO_AGE, newClassMo.getAge());
    }
}
package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.launchcode.techjobs_oo.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job test_job1 = new Job();
        Job test_job2 = new Job();
        assertEquals(test_job1.getId(), test_job2.getId(), 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job instanceof Job);
        assertEquals("Product tester", test_job.getName());
        assertEquals("ACME", test_job.getEmployer().getValue());
        assertEquals("Desert", test_job.getLocation().getValue());
        assertEquals("Quality control", test_job.getPositionType().getValue());
        assertEquals("Persistence", test_job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test_job1.equals(test_job2));
    }

    @Test
    public void testReturnedStringStartsEndsWithBlankLine() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job.toString().contains("\n" + "\n"));
    }

    @Test
    public void testStringContainsLabelData() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job.toString().contains("ID: " + test_job.getId()));
        assertTrue(test_job.toString().contains("Name: " + test_job.getName()));
        assertTrue(test_job.toString().contains("Employer: " + test_job.getEmployer()));
        assertTrue((test_job.toString().contains("Location: " + test_job.getLocation())));
        assertTrue(test_job.toString().contains("Position Type: " + test_job.getPositionType()));
        assertTrue(test_job.toString().contains("Core Competency: " + test_job.getCoreCompetency()));
    }

    @Test
    public void testEmptyField() {
        Job test_job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job.toString().contains("Data not available"));
        assertTrue(test_job1.toString().contains("Data not available"));
    }
}

import org.example.members.Members;
import org.example.members.MembersService;
import org.example.participation.Participation;
import org.example.surveys.Surveys;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MembersTest {

    @Test
    public void testIfTheGivenSurveyCompletedBySomeone() {
        //Given
        List<Participation> participation = new ArrayList<>();
        participation.add(new Participation(1,1, 4, 16));
        participation.add(new Participation(2, 3, 3, null));
        participation.add(new Participation(3, 10, 4, 20));
        List<Members> members = new ArrayList<>();
        members.add(new Members.MemberBuilder(1, "John Smith", "john@gmail.com", (short)1).build());
        members.add(new Members.MemberBuilder(2, "Hanna McKay", "hannah88@gmail.com", (short)1).build());

        // When
        Members memberMock = mock(Members.class);
        when(memberMock.getId()).thenReturn(1);
        MembersService serviceIn = new MembersService();

        // Then
        List<Members> result = serviceIn.listOfGivenSurveyCompletedMembers(1, participation, members);

        assertEquals(1, result.size());
    }

    @Test
    public void testCollectedPointsByGivenMember() {
        // Given
        List<Surveys> surveys = new ArrayList<>();
        List<Participation> participation = new ArrayList<>();
        surveys.add(new Surveys(1,"Survey 1", 40, 20, 8));
        surveys.add(new Surveys(2, "Survey 2", 15, 25, 7));
        surveys.add(new Surveys(3, "Survey 3", 30, 25, 8));
        participation.add(new Participation(1, 1, 4, 15));
        participation.add(new Participation(2, 1, 3, 15));
        participation.add(new Participation(3, 1, 4, 15));
        participation.add(new Participation(1, 3, 3, 20));

        //When
        MembersService memberIn = new MembersService();

        // Then
        int result = memberIn.collectedPointsByGivenMember(1, surveys, participation);
        assertEquals(28, result);
    }
}

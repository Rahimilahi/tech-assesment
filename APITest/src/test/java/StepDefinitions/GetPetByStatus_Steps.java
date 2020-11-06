package StepDefinitions;

import Clients.GetPets;
import Clients.Pet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class GetPetByStatus_Steps {
    String jsonResponse;

    @Given("i perform a {string} method with a status of {string}")
    public void i_perform_a_method_with_a_status_of(String methodType, String status) {
        jsonResponse = GetPets.getPetsByStatus(methodType, status);
    }

    @When("i sort by by name {string} and status {string}")
    public void i_sort_by_by_name(String name, String status) throws Exception {
     List<Pet> pet = getPetsByName(name, status);

    }

    @Then("i should see {int} pets are returned with name {string} and status {string}")
    public void i_should_see_how_many_pets_are_returned(int total, String name, String status ) throws Exception {
        Assert.assertEquals(total,pets.size(),"The total number of pets returned was ");
        
        }

        private List<Pet> getPetsByName(String name, String status) throws Exception{
            ObjectMapper mapper = new ObjectMapper();
            List<Pet> pets = new ObjectMapper().readValue(jsonResponse, new TypeReference<List<Pet>>(){});

             return pets
                    .stream()
                    .filter(p -> p != null && p.getName() != null && p.getName().equals(name) && p.getStatus().equals(status))
                    .collect(Collectors.toList());

        }
    }



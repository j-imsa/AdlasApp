package ir.adlas.adlasapp.thirdparty;

import java.util.List;

public interface AVSApi {

    /**
     * creates a hostset
     *
     * @param name the name of the hostset
     * @return the id
     */
    Long createHostset(String name);

    /**
     * deletes a hostset by its id
     *
     * @param id the id of the hostset
     */
    void deleteHostset(Long id);

    /**
     * creates a policy
     *
     * @param policyName the name of the policy
     * @param excludedApplications the list of excluded applications
     * @return the id of the policy
     */
    String createPolicy(String policyName, List<String> excludedApplications);

    /**
     * deletes a policy by its id
     *
     * @param id the id of the policy
     */
    void deletePolicy(String id);

    /**
     * joins a policy and a hostset
     *
     * @param pid the policy id
     * @param hsid the hostset id
     */
    void joinPolicyAndHostset(String pid, Long hsid);

    /**
     * removes a host from a hostset
     *
     * @param hsid the id of the hostset
     * @param hostIds the hosts to be removed
     */
    void removeHostsFromHostset(Long hsid, List<String> hostIds);

    /**
     * prints the state of the simulated AVS to stdout
     */
    void print();

}

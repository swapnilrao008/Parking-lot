package main.java.Repositories;

import main.java.Exceptions.GateNotFoundException;
import main.java.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
   private Map<Long,Gate> gates=new HashMap<>();

    public Map<Long, Gate> getGates() {
        return gates;
    }

    public void setGates(Map<Long, Gate> gates) {
        this.gates = gates;
    }

    public Gate findGateById(Long id) throws GateNotFoundException {
        if(gates.containsKey(id)) {
            return gates.get(id);
        }
        throw new GateNotFoundException();
    }
}

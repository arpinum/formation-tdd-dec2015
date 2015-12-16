package mocks;

import com.google.common.collect.Lists;
import es.SortieStandard;

import java.util.List;

public class MockSortieStandard implements SortieStandard {
    @Override
    public void affiche(String message) {
        affichages.add(message);
    }

    public List<String> affichages = Lists.newArrayList();
}

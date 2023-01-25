package com.lesnoy.openbook.history;

import com.lesnoy.openbook.book.UserBookPKId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, UserBookPKId> {
}

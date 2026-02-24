# Star Wars Bounty Board CLI

Simple CLI app for a Star Wars themed bounty board.

## Features
- Choose a role: Syndicate, Bounty Hunter, or Visitor
- Anyone can view the current bounty board
- Syndicates can create bounties and delete incomplete bounties
- Bounty Hunters can claim unassigned bounties and mark assigned bounties complete
- Uses a strategy pattern for menu system

## Requirements
- Java 17+
- MySQL server with BoutyHunterBoard database running

## How to run

```bash
./gradlew -q --console=plain run --args="jdbc:mysql://localhost:3306/BoutyHunterBoard <Username> <password>"
```
